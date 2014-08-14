package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Instruction;

public abstract class AbstractInstruction<T> implements Instruction<T> {

	protected static int WORD_SIZE = 0xff;

}
