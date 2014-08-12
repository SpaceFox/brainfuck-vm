package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Instruction;
import info.kisai.vm.Processor;

public class Output implements Instruction<Integer> {

	@Override
	public char optCode() {
		return '.';
	}

	@Override
	public void execute(Processor<Integer> processor) {
		System.out.print(new String(Character.toChars(processor.getDataAt(processor.getDataPointer()))));
	}

}
