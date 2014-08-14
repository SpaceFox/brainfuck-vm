package info.kisai.vm.impl.brainfuck;

import info.kisai.vm.Memory;
import info.kisai.vm.ProgramMemory;

public class BrainfuckVM {

	private static final int PROGRAM_MEM_SIZE = 30_000;
	private static final int DATA_MEM_SIZE = 30_000;

	private BrainfuckProcessor processor;
	private ProgramMemory<Integer> programMemory;
	private Memory<Integer> dataMemory;

	public BrainfuckVM() {
		programMemory = new ProgramMemory<>(PROGRAM_MEM_SIZE);
		dataMemory = new Memory<>(DATA_MEM_SIZE);
		for (int i = 0; i < DATA_MEM_SIZE; i++) {
			dataMemory.add(0);
		}
		processor = new BrainfuckProcessor();
		processor.attachMemories(programMemory, dataMemory);
	}

	public void loadProgram(String rawProgram) {

		CompiledProgram compile = Compiler.compile(rawProgram.toCharArray());
//		System.out.println(compile);
		processor.loadProgram(compile);
	}

	public void run() {
		processor.run();
	}

}
