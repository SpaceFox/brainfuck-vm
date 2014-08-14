package info.kisai.vm;

import info.kisai.vm.impl.brainfuck.CompiledProgram;


public class ProgramMemory<T> extends Memory<ParametredInstruction<T>> {

	public ProgramMemory(int capacity) {
		super(capacity);
	}

	public void load(CompiledProgram program, InstructionSet<T> instructionSet) {

		Instruction<T> instruction;

		for (int i = 0; i < program.getOptCodes().length; i++) {

			instruction = instructionSet.decode(program.getOptCodes()[i]);

			if (instruction != null) {
				this.add(new ParametredInstruction<>(instruction, program.getParameters()[i]));
			}
		}
	}

}
