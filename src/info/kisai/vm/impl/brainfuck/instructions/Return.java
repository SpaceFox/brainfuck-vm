package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Processor;

public class Return extends AbstractInstruction<Integer> {

	@Override
	public char optCode() {
		return ']';
	}

	@Override
	public void execute(Processor<Integer> processor, int parameter) {
		if (processor.getDataAt(processor.getDataPointer()) != 0) {
			processor.setProgramPointer(parameter);
		}
	}

}
