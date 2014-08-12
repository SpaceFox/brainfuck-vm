package info.kisai.vm;

import java.util.HashSet;

public class InstructionSet<T> extends HashSet<Instruction<T>> {

	public Instruction<T> decode(char optCode) {
		for (Instruction<T> instruction : this) {
			if (instruction.optCode() == optCode) {
				return instruction;
			}
		}
		return null;
	}
}
