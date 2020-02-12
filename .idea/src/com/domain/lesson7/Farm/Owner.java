package com.domain.lesson7.Farm;

import com.domain.lesson7.Farm.HomeAnimal.HomeAnimal;

public interface Owner {
    void lastRes();
    void takeRes(HomeAnimal homeAnimal);
    void eatHomeAnimal(HomeAnimal homeAnimal);
    void feedAnimals(HomeAnimal homeAnimal);
    boolean dispossWildAnimals();

}
