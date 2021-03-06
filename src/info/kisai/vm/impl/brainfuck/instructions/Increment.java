package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Instruction;
import info.kisai.vm.Processor;

public class Increment implements Instruction<Integer> {

	@Override
	public char optCode() {
		return '+';
	}

	@Override
	public void execute(Processor<Integer> processor) {
		int data = processor.getDataAt(processor.getDataPointer()) + 1;
		if (data > 0xff) {
			data -= 0xff;
		}
		processor.setDataAt(processor.getDataPointer(), data);
	}

}
