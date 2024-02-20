import java.util.Objects;

public final class Test extends Assay {

  /**
   * Класс Теста Test является финальным производным классом от класса Assay. Имеет атрибуты topic
   * (название темы), tasksAmount (количество заданий)
   */
  private String topic = null;
  private int tasksAmount = 0;

  /**
   * Пустой конструктор
   */
  public Test() {
    super();
  }

  /**
   * Конструктор создания объекта с веденным параматрами:
   *
   * @param name        (название испытания),
   * @param mark        (полученная оценка),
   * @param topic       (название темы),
   * @param TasksAmount (количество заданий)
   */
  public Test(String name, int mark, String topic, int TasksAmount) {
    super(name, mark);
    this.topic = topic;
    this.tasksAmount = TasksAmount;
  }

  /**
   * Метод установки названия темы. Принимает @param topic
   */
  public void setTopic(String topic) {
    this.topic = topic;
  }

  /**
   * Метод установки количества заданий. Принимает @param tasksAmount
   */
  public void setTasksAmount(int tasksAmount) {
    if (tasksAmount <= 0) {
      System.out.println("Количество заданий должно быть положительным");
    }
    this.tasksAmount = tasksAmount;
  }

  /**
   * Метод получения названия темы
   *
   * @return topic
   */
  public String getTopic() {
    return topic;
  }

  /**
   * Метод получения количества заданий
   *
   * @return tasksAmount
   */
  public int getTasksAmount() {
    return tasksAmount;
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
    Test that = (Test) o;
    if (that.getMark() != getMark()) {
      return false;
    }
    if (!that.topic.equals(topic)) {
      return false;
    }
    if (that.tasksAmount != tasksAmount) {
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
    return Objects.hash(super.hashCode(), topic, tasksAmount);

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
        ___Тест___
        Название испытания: %s
        Оценка: %d
        Тема: %s
        Количество заданий: %d
        """, getName(), getMark(), topic, tasksAmount);
  }

}
