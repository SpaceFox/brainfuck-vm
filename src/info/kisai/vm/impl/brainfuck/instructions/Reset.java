package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Processor;

public class Reset extends AbstractInstruction<Integer> {

	@Override
	public char optCode() {
		return '0';
	}

	@Override
	public void execute(Processor<Integer> processor, int parameter) {
		processor.setDataAt(processor.getDataPointer(), 0);
	}
}