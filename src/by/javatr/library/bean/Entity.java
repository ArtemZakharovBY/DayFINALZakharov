package by.javatr.library.bean;

import java.io.Serializable;

/**
 *An interface of all entities that extends {@link Serializable}
 *@author Zakharov Artem
 *@version 1.0
 */
public interface Entity extends Serializable, Cloneable{// не балуйся с интерфейсом Cloneable, особенно в иерархии в верхних ее частях
  // разрешать для всего создавать копию по умолчанию - плохое решение
}

