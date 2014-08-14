package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Processor;

public class Move extends AbstractInstruction<Integer> {

	@Override
	public char optCode() {
		return '>';
	}

	@Override
	public void execute(Processor<Integer> processor, int parameter) {
		processor.setDataPointer(processor.getDataPointer() + parameter);
	}

}
