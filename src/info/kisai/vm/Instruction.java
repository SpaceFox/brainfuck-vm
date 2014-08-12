package info.kisai.vm;


public interface Instruction<T> {

	char optCode();

	void execute(Processor<T> processor);

}
