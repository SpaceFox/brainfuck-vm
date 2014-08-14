package info.kisai.vm;

public class ParametredInstruction<T> {

	private Instruction<T> instruction;
	private int parameter;

	public ParametredInstruction(Instruction<T> instruction, int parameter) {
		super();
		this.instruction = instruction;
		this.parameter = parameter;
	}

	public void execute(Processor<T> processor) {
		instruction.execute(processor, parameter);
	}

}
