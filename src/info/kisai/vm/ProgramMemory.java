package info.kisai.vm;


public class ProgramMemory<T> extends Memory<Instruction<T>> {

	public ProgramMemory(int capacity) {
		super(capacity);
	}

	public void load(char[] optCodes, InstructionSet<T> instructionSet) {

		Instruction<T> instruction;

		for (char optCode : optCodes) {

			instruction = instructionSet.decode(optCode);

			if (instruction != null) {
				this.add(instruction);
			}
		}
	}

}
