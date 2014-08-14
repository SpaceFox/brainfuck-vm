package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Processor;

public class Copy extends AbstractInstruction<Integer> {

	@Override
	public char optCode() {
		return 'm';
	}

	@Override
	public void execute(Processor<Integer> processor, int parameter) {
		processor.setDataAt(
				processor.getDataPointer() + 1,
				processor.getDataAt(processor.getDataPointer()));
		processor.setDataAt(processor.getDataPointer(), 0);
	}

}
