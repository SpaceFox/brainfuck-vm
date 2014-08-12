package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Instruction;
import info.kisai.vm.Processor;

public class Jump implements Instruction<Integer> {

	private static final char RETURN_OPTCODE = new Return().optCode();

	@Override
	public char optCode() {
		return '[';
	}

	@Override
	public void execute(Processor<Integer> processor) {

		int pointer = processor.getProgramPointer();

		if (processor.getDataAt(processor.getDataPointer()) == 0) {

			int depth = 1;
			Instruction<Integer> instruction;

			while (depth > 0) {

				pointer++;
				instruction = processor.getInstructionAt(pointer);

				if (optCode() == instruction.optCode()) {
					depth++;
				} else if (RETURN_OPTCODE == instruction.optCode()) {
					depth--;
				}
			}
			processor.setProgramPointer(pointer);
		}
	}

}
