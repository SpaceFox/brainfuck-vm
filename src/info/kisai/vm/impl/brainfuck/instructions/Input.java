package info.kisai.vm.impl.brainfuck.instructions;

import info.kisai.vm.Instruction;
import info.kisai.vm.Processor;

import java.util.Scanner;

public class Input implements Instruction<Integer> {

	private final Scanner scanner = new Scanner(System.in);

	@Override
	public char optCode() {
		return ',';
	}

	@Override
	public void execute(Processor<Integer> processor) {
		processor.setDataAt(processor.getDataPointer(), Integer.valueOf(scanner.next().codePointAt(0)));
	}

}
