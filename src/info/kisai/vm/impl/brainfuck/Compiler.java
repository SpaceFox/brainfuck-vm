package info.kisai.vm.impl.brainfuck;

public class Compiler {

	public static CompiledProgram compile(char[] program) {

		char[] progWithoutComments = preprocess(removeComments(program));

		final int size = progWithoutComments.length;
		char[] tmpProg = new char[size];
		int[] tmpParams = new int[size];

		// Compilation
		int iProg = 0;
		int compiledSize = 0;
		int compteur = 0;
		char instr;
		char instrPrec = '\u0000';

		while (iProg < size) {

			instr = progWithoutComments[iProg];

			// Instructions cumulables
			if (	(instr != instrPrec)
				&&	(instrPrec == '+' || instrPrec == '-' || instrPrec == '>' || instrPrec == '<')
			) {
				tmpProg[compiledSize] = instrPrec == '-' ? '+' : instrPrec == '<' ? '>' : instrPrec;
				tmpParams[compiledSize] = compteur;
				compiledSize++;
				compteur = 0;
			}

			// Instructions à ajouter direct
			if (	instr == '['|| instr == ']' || instr == '.' || instr == ','
				||	instr == '0' || instr == 'a' || instr == 'm') {
				tmpProg[compiledSize] = instr;
				compiledSize++;
				compteur = 0;
			}

			// Modif du compteur si besoin
			if (instr == '+' || instr == '>') {
				compteur++;
			}
			else if (instr == '-' || instr == '<') {
				compteur--;
			}
			instrPrec = instr;
			iProg++;
		}

		// Correspondances
		for (int iCrochetOuvrant = 0; iCrochetOuvrant < compiledSize; iCrochetOuvrant++) {
			if (tmpProg[iCrochetOuvrant] == '[') {
				int nbCrochets = 1;
				int iCrochetFermant = iCrochetOuvrant;
				while (nbCrochets > 0) {
					iCrochetFermant++;
					if (tmpProg[iCrochetFermant] == '[') {
						nbCrochets++;
					} else if(tmpProg[iCrochetFermant] == ']') {
						nbCrochets--;
					}
				}
				// Correspondance [ --> ]
				tmpParams[iCrochetOuvrant] = iCrochetFermant;
				// Correspondance ] --> [
				tmpParams[iCrochetFermant] = iCrochetOuvrant;
			}
		}

		// Copie dans les tableaux généraux
		char[] optCodes = new char[compiledSize];
		int[] parameters = new int[compiledSize];
		System.arraycopy(tmpProg, 0, optCodes, 0, compiledSize);
		System.arraycopy(tmpParams, 0, parameters, 0, compiledSize);
//		System.out.println("Taille compilée : " + tailleProgComp);

		return new CompiledProgram(optCodes, parameters);
	}

	private static char[] preprocess(char[] program) {

		String str = new String(program);

//		// RAZ cellule
		str = str.replaceAll("\\[-\\]", "0");
//		// Addition
		str = str.replaceAll("\\[->\\+<\\]", "a");
//		// Copy
		str = str.replaceAll(">\\[-\\]<\\[->\\+<\\]", "m");

		return str.toCharArray();
	}

	private static char[] removeComments(char[] program) {
		char[] tmp = new char[program.length];
		int size = 0;
		for (char c : program) {
			if (c == '+' || c == '-' || c == '>' || c == '<'  || c == '[' || c == ']' || c == '.' || c == ',') {
				tmp[size++] = c;
			}
		}
		char[] out = new char[size];
		System.arraycopy(tmp, 0, out, 0, size);
		return out;
	}
}
