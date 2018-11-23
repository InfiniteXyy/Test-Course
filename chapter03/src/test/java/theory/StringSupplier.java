package theory;

import java.util.ArrayList;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class StringSupplier extends ParameterSupplier {

  @Override
  public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
    List<PotentialAssignment> list = new ArrayList<>();
    list.add(PotentialAssignment.forValue("String", "Software"));
    list.add(PotentialAssignment.forValue("String", "Testing"));
    return list;
  }
}
