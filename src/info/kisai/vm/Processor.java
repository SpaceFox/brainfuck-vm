package info.kisai.vm;

import java.util.Set;

public abstract class Processor<T> {

	private InstructionSet<T> instructionSet = new InstructionSet<>();

	private ProgramMemory<T> programMemory;
	private Memory<T> dataMemory;
	private int programPointer;
	private int dataPointer;

	protected void defineInstructionSet(Set<Instruction<T>> instructions) {
		for (Instruction<T> instruction : instructions) {
			instructionSet.add(instruction);
		}
	}

	public void attachMemories(ProgramMemory<T> programMemory, Memory<T> dataMemory) {
		this.programMemory = programMemory;
		this.dataMemory = dataMemory;
	}

	public void loadProgram(char[] optCodes) {
		programMemory.load(optCodes, instructionSet);
	}

	public void run() {
		while (programPointer < programMemory.size()) {
			programMemory.get(programPointer).execute(this);
			programPointer++;
		}
	}

	public int getProgramPointer() {
		return programPointer;
	}

	public void setProgramPointer(int programPointer) {
		this.programPointer = programPointer;
	}

	public int getDataPointer() {
		return dataPointer;
	}

	public void setDataPointer(int dataPointer) {
		this.dataPointer = dataPointer;
	}

	public T getDataAt(int memoryPointer) {
		return dataMemory.get(memoryPointer);
	}

	public void setDataAt(int memoryPointer, T data) {
		dataMemory.set(memoryPointer, data);
	}

	public Instruction<T> getInstructionAt(int programPointer) {
		return programMemory.get(programPointer);
	}
}
