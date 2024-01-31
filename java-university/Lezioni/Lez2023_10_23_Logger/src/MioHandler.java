import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MioHandler extends Handler {

	@Override
	public void publish(LogRecord record) {
		System.out.print(record.getLevel()+ " ");
		System.out.print(record.getSourceClassName() + " ");
		System.out.print(record.getSourceMethodName() + " ");
		System.out.println(record.getMessage());

	}

	@Override
	public void flush() {
		
	}

	@Override
	public void close() throws SecurityException {
	

	}

}
