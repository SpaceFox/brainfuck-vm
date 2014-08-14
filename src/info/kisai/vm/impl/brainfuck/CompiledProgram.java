package info.kisai.vm.impl.brainfuck;

public class CompiledProgram {

	private char[] optCodes;
	private int[] parameters;

	public CompiledProgram(char[] optCodes, int[] parameters) {
		super();
		this.optCodes = optCodes;
		this.parameters = parameters;
	}

	public char[] getOptCodes() {
		return optCodes;
	}

	public int[] getParameters() {
		return parameters;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(optCodes.length * 8);
		for (int i = 0; i < optCodes.length; i++) {
			sb	.append(i)				.append('\t')
				.append(optCodes[i])	.append(' ')
				.append(parameters[i])	.append('\n');
		}
		return sb.toString();
	}


}