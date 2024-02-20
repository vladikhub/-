import java.util.Objects;

public class Exam extends Assay {

  /**
   * Класс Экзамена Exam явяется производным класса Assay. Имеет атрибуты subject (название
   * предмета, по которому сдается экзамен), topicsAmount (количество тем)
   */
  private String subject = null;
  private int topicsAmount = 0;

  /**
   * Пустой конструктор
   */
  public Exam() {
  }

  /**
   * Конструктор с веденными параметрами, принимает:
   *
   * @param name         (название испытания)
   * @param mark         (полученная оценка)
   * @param subject      (название предмета)
   * @param topicsAmount (количество тем)
   */
  public Exam(String name, int mark, String subject, int topicsAmount) {
    super(name, mark);
    this.subject = subject;
    this.topicsAmount = topicsAmount;
  }

  /**
   * Метод получения названия предмета
   *
   * @return subject
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Метод получения количества тем
   *
   * @return topicsAmount
   */
  public int getTopicsAmount() {
    return topicsAmount;
  }

  /**
   * Метод установки названия предмета. Принимает @param subject
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * Метод установки количества тем. Принимает @param topicsAmount
   */
  public void setTopicsAmount(int topicsAmount) {
    if (topicsAmount <= 0) {
      System.out.println("Количество тем должно быть положительным");
    }
    this.topicsAmount = topicsAmount;
  }

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
    Exam that = (Exam) o;
    if (that.getMark() != getMark()) {
      return false;
    }
    if (!that.subject.equals(subject)) {
      return false;
    }
    if (that.topicsAmount != topicsAmount) {
      return false;
    }
    return getName().equals(that.getName());
  }

  /**
   * Переопределяемый метод hashCode, отвечающий за вычисление хеш-кода объекта. Вычисляет хеш-код
   * супер-класса и добавляет к результату хеш-код аргументов данного класса. Возвращает @return
   * result (хеш-код)
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), subject, topicsAmount);
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
        ___Экзамен___
        Название испытания: %s
        Оценка: %d
        Предмет: %s
        Количество тем: %d
        """, getName(), getMark(), subject, topicsAmount);
  }
}
