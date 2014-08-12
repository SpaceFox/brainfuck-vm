package info.kisai.vm.impl.brainfuck;

import info.kisai.vm.Instruction;
import info.kisai.vm.Processor;
import info.kisai.vm.impl.brainfuck.instructions.Decrement;
import info.kisai.vm.impl.brainfuck.instructions.Increment;
import info.kisai.vm.impl.brainfuck.instructions.Input;
import info.kisai.vm.impl.brainfuck.instructions.Jump;
import info.kisai.vm.impl.brainfuck.instructions.Next;
import info.kisai.vm.impl.brainfuck.instructions.Output;
import info.kisai.vm.impl.brainfuck.instructions.Previous;
import info.kisai.vm.impl.brainfuck.instructions.Return;

import java.util.HashSet;
import java.util.Set;

public class BrainfuckProcessor extends Processor<Integer> {

	public BrainfuckProcessor() {
		super();
		Set<Instruction<Integer>> instructionSet = new HashSet<>();
		instructionSet.add(new Increment());
		instructionSet.add(new Decrement());
		instructionSet.add(new Next());
		instructionSet.add(new Previous());
		instructionSet.add(new Input());
		instructionSet.add(new Output());
		instructionSet.add(new Jump());
		instructionSet.add(new Return());
		defineInstructionSet(instructionSet);
	}

}
