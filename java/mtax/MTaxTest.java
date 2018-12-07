package mtax;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@DisplayName("Pruebas unitarias clase MTax")
@RunWith(PowerMockRunner.class)
class MTaxTest {

    private MTax mtaxClass;
    @Mock
    private ArrayList<String> mockArrayList;

    @BeforeEach
    void setUp() {
        mtaxClass = new MTax();
    }

    @DisplayName("Test Validate Happy path")
    @Test
    void validate_hp() {
       when(mtaxClass.validate(any())).thenReturn(mock(ArrayList.class));
    }

    @Test
    void validate_error(){
        List<X_Tax> mockedList = new ArrayList<X_Tax>();
        doThrow((Throwable) when(mtaxClass.validate(mockedList)));
        mtaxClass.validate(mockedList);

    }

    @Test
    void validateIds_hp() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        List<X_Tax> x_taxList = createList();
        when(mtaxClass.ValidateIds(any(), any())).thenReturn(mockArrayList);
        mtaxClass.ValidateIds(x_taxList, list);
    }

    @Test
    void validateIds_error() {
        doThrow((Throwable) when(mtaxClass.ValidateIds(any(), any())));
    }

    private List<X_Tax> createList(){
        List<X_Tax> x_Taxes = new ArrayList<X_Tax>();
        X_Tax tax1 = new X_Tax();
        X_Tax tax2 = new X_Tax();
        tax1.setId("1");
        tax1.setCreated(new Date());
        tax1.setId("2");
        tax1.setCreated(new Date());
        x_Taxes.add(tax1);
        x_Taxes.add(tax2);
        return x_Taxes;
    }
}