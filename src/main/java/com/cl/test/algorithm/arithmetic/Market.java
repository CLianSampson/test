
package com.cl.test.algorithm.arithmetic;

import lombok.Data;


/**
 *
 * @author chenlian
 * @version 1.0
 * @date 2023/7/26 16:44
 */
@Data
public class Market implements Cloneable {


    private int number;

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return null != obj;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        throw new java.io.NotSerializableException("com.cl.test.algorithm.arithmetic.Market");
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        throw new java.io.NotSerializableException("com.cl.test.algorithm.arithmetic.Market");
    }
}