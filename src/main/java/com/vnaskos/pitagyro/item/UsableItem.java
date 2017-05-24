package com.vnaskos.pitagyro.item;

import com.vnaskos.pitagyro.item.property.Usable;
import java.io.Serializable;

/**
 *
 * @author Vasilis Naskos
 * @param <T> the type of the value
 */
public class UsableItem<T> extends PassiveItem implements Usable, Serializable {

    private static final long serialVersionUID = 7107696797941126600L;
    
    private final UseCase useCase;
    private final T value;
    
    public UsableItem(String name, UseCase useCase, T value) {
        super(name, String.format("Change %s by value %s",
                useCase.toString().toLowerCase(), value.toString()));
        
        this.useCase = useCase;
        this.value = value;
    }

    @Override
    public UseCase getUseCase() {
        return useCase;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public boolean canUse() {
        return true;
    }
}
