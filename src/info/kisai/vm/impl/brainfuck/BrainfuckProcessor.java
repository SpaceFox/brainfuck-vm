package info.kisai.vm.impl.brainfuck;

import info.kisai.vm.Instruction;
import info.kisai.vm.Processor;
import info.kisai.vm.impl.brainfuck.instructions.Add;
import info.kisai.vm.impl.brainfuck.instructions.AddMem;
import info.kisai.vm.impl.brainfuck.instructions.Copy;
import info.kisai.vm.impl.brainfuck.instructions.Input;
import info.kisai.vm.impl.brainfuck.instructions.Jump;
import info.kisai.vm.impl.brainfuck.instructions.Move;
import info.kisai.vm.impl.brainfuck.instructions.Output;
import info.kisai.vm.impl.brainfuck.instructions.Reset;
import info.kisai.vm.impl.brainfuck.instructions.Return;

import java.util.HashSet;
import java.util.Set;

public class BrainfuckProcessor extends Processor<Integer> {

	public BrainfuckProcessor() {
		super();
		Set<Instruction<Integer>> instructionSet = new HashSet<>();
		instructionSet.add(new Add());
		instructionSet.add(new Move());
		instructionSet.add(new Input());
		instructionSet.add(new Output());
		instructionSet.add(new Jump());
		instructionSet.add(new Return());
		instructionSet.add(new Reset());
		instructionSet.add(new AddMem());
		instructionSet.add(new Copy());
		defineInstructionSet(instructionSet);
	}

}
