package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Processor;

public class AddMem extends AbstractInstruction<Integer> {

	@Override
	public char optCode() {
		return 'a';
	}

	@Override
	public void execute(Processor<Integer> processor, int parameter) {
		processor.setDataAt(
				processor.getDataPointer() + 1,
				(processor.getDataAt(processor.getDataPointer())
						+ processor.getDataAt(processor.getDataPointer() + 1))
						% WORD_SIZE);
		processor.setDataAt(processor.getDataPointer(), 0);
	}

}
