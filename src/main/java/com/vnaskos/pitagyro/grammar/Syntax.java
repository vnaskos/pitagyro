package com.vnaskos.pitagyro.grammar;

import com.vnaskos.pitagyro.command.CommandArgument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Vasilis Naskos
 */
public class Syntax {
    
    public static enum Type {
        VERB, ITEM, DIRECTION
    }
    
    private final Type[] parts;

    public Syntax(Type... parts) {
        this.parts = parts;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Syntax other = (Syntax) obj;
        
        return Arrays.deepEquals(this.parts, other.parts);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Arrays.deepHashCode(this.parts);
        return hash;
    }
    
    public static class Builder {
        
        private final List<Type> parts;

        public Builder() {
            parts = new ArrayList<>();
        }
        
        public Builder add(Type type) { parts.add(type); return this; }
        
        public Builder verb() { parts.add(Type.VERB); return this; }
        
        public Builder item() { parts.add(Type.ITEM); return this; }
        
        public Builder direction() { parts.add(Type.DIRECTION); return this; }
        
        public Syntax build() {
            return new Syntax(parts.toArray(new Type[]{}));
        }
        
        public void clear() {
            parts.clear();
        }
    }
}
