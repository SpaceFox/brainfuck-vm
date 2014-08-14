package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Processor;

public class Output extends AbstractInstruction<Integer> {

	@Override
	public char optCode() {
		return '.';
	}

	@Override
	public void execute(Processor<Integer> processor, int parameter) {
		System.out.print(Character.toChars(processor.getDataAt(processor.getDataPointer())));
	}

}
