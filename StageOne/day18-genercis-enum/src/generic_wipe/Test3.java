package generic_wipe;

import java.util.Date;

/**
 *  类型擦除和多态的冲突
 */
public class Test3 extends Pair<Date>{
    @Override
    public Date getValue(){
        return super.getValue();
    }
    @Override
    public void setValue(Date data){
        super.setValue(data);
    }
    /*
    public void setValue(Object obj){
        //...
        this.setValue(Date obj);
    }
     */
}
