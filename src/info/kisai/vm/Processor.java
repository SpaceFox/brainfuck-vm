package info.kisai.vm;

import info.kisai.vm.impl.brainfuck.CompiledProgram;

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

	public void loadProgram(CompiledProgram program) {
		programMemory.load(program, instructionSet);
	}

	public void run() {
		long c = 0;
		long tStart = System.currentTimeMillis();
		while (programPointer < programMemory.size()) {
			c++;
//			System.out.println(programPointer + "\t" + programMemory.get(programPointer));
			programMemory.get(programPointer).execute(this);
			programPointer++;
		}
		long time = System.currentTimeMillis() - tStart;
        System.out.println("\n" + c + " instructions en " + time + " ms --> " + (c / (time * 1000D)) + " MHz");
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
}
