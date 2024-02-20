import java.util.Objects;

public final class FinalExam extends Exam {

  /**
   * Финальный класс Выпускного Экзамена FinalExam является производным от класса Exam имеет
   * атрибуты examName (название экзамена), period (время обучения, за которое сдается экзамен)
   */
  private String examName = null;
  private int period = 0;

  /**
   * Пустой конструктор
   */
  public FinalExam() {
  }

  /**
   * Конструктор с веденным аргументами, принимает:
   *
   * @param name         (название испытания)
   * @param mark         (полученная оценка)
   * @param subject      (название предмета)
   * @param topicsAmount (количество тем)
   * @param examName     (название экзамена)
   * @param period       (время обучения)
   */
  public FinalExam(String name, int mark, String subject, int topicsAmount, String examName,
      int period) {
    super(name, mark, subject, topicsAmount);
    this.examName = examName;
    this.period = period;
  }

  /**
   * Метод получения названия экзамена
   *
   * @return examName
   */
  public String getExamName() {
    return examName;
  }

  /**
   * Метод получения времения обучения
   *
   * @return period
   */
  public int getPeriod() {
    return period;
  }

  /**
   * Метод для установки названия экзамена. Принимает @param examName
   */
  public void setExamName(String examName) {
    this.examName = examName;
  }

  /**
   * Метод получения времения обучения. Приниамает @param period
   */
  public void setPeriod(int period) {
    if (period <= 0) {
      System.out.println("Период обучения должен быть положительным");
    }
    this.period = period;
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
    FinalExam that = (FinalExam) o;
    if (that.getMark() != getMark()) {
      return false;
    }
    if (!that.getSubject().equals(getSubject())) {
      return false;
    }
    if (that.getTopicsAmount() != getTopicsAmount()) {
      return false;
    }
    if (!that.examName.equals(examName)) {
      return false;
    }
    if (that.period != period) {
      return false;
    }
    return getName().equals(that.getName());
  }

  /**
   * Переопределяемый метод hashCode, отвечающий за вычисление хеш-кода объекта. Вычисляет хеш-код
   * супер-класса и добавляет к результату хеш-код аргументов данного класса. Возвращает
   * @return result (хеш-код)
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), examName, period);
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
        ___Выпускной Экзамен___
        Название испытания: %s
        Оценка: %d
        Предмет: %s
        Количество тем: %d
        Название выпускного экзамена: %s
        Период обучения: %d
        """, getName(), getMark(), getSubject(), getTopicsAmount(), examName, period);
  }
}
