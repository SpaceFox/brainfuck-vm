package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Instruction;
import info.kisai.vm.Processor;

public class Next implements Instruction<Integer> {

	@Override
	public char optCode() {
		return '>';
	}

	@Override
	public void execute(Processor<Integer> processor) {
		processor.setDataPointer(processor.getDataPointer() + 1);
	}

}
