public class Assay {

  /**
   * Класс испытания Assay, являющийся родительским классом. Имеет атрибуты assayName (Название
   * испытания), mark (Оценка за испытание)
   */
  private String assayName = null;
  private int mark = 0;

  /**
   * Переопрееляемый метод equals, отвечающий за сравнивание объектов на равенство.
   * Принимает объект @param o
   *
   * @return true или false, если все аргументы объектов равны или нет
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Assay that = (Assay) o;
    if (that.mark != mark) {
      return false;
    }
    return assayName.equals(that.assayName);
  }

  /**
   * Переопределяемый метод hashCode, отвечающий за вычисление хеш-кода объекта. Возвращает @return
   * result (хеш-код)
   */
  @Override
  public int hashCode() {
    int result = assayName == null ? 0 : assayName.hashCode();
    result += mark * 37;
    return result;
  }

  /**
   * Пустой конструктор
   */
  public Assay() {
  }

  /**
   * Конструктор с веденными параметрами, принимает:
   *
   * @param name (Название испытания),
   * @param mark (Оценка)
   */
  public Assay(String name, int mark) {
    this.assayName = name;
    this.mark = mark;
  }

  /**
   * Метод получения названия Испытания
   *
   * @return assayName
   */
  public String getName() {
    return assayName;
  }

  /**
   * Метод получения оценки
   *
   * @return mark
   */
  public int getMark() {
    return mark;
  }

  /**
   * Метод установки названия Испытания. Принимает @param name
   */
  public void setName(String name) {
    this.assayName = name;
  }

  /**
   * Метод установки оценки Принимает @param mark
   */
  public void setMark(int mark) {
    if (mark < 0) {
      System.out.println("Оценка должна быть неотрицательная");
    }
    this.mark = mark;
  }

  /**
   * Переопределенный метод toString, отвечающий за представления объекта класса в строком удобном
   * виде
   *
   * @return форматированную строку
   */
  @Override
  public String toString() {
    return String.format("""
        ___Испытание___
        Название испытания: %s
        Оценка: %d
        """, assayName, mark);
  }
}