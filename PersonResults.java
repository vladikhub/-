// Автор работы: Смольков Владислав Андреевич, КИ23-16/1б
// Практическая работа №3, Вариант 5


import java.util.ArrayList;
import java.util.Scanner;

public class PersonResults {

  /**
   * Главный класс-контейнер, который будет хранить результаты в виде объектов классов: Assay, Test,
   * Exam, FinalExam Имеет атрибуты Сканер sc и ArrayList results
   */
  public static Scanner sc = new Scanner(System.in);
  public static ArrayList<Assay> results = new ArrayList<>();

  /**
   * Главный метод main, отвечающий за вызов Меню и связь с пользователем
   */
  public static void main(String[] args) {
    boolean running = true;
    while (running) {
      System.out.println("""
          ___МЕНЮ___
          1. Добавить пустое место для результата
          2. Добавить результат
          3. Удалить результат
          4. Показать все результаты
          5. Сравнить два результата
          6. Редактировать результат
          7. Выход
          """);
      System.out.println("Выберете пункт:");
      /*
       * Считывание действия пользователя и его результат
       */
      String act = sc.nextLine();
      switch (act) {
        case "7":
          System.out.println("Выход из приложения...");
          running = false;
          break;
        case "1":
          addFieldForResult();
          System.out.println("Пустое поле для результата добавлено");
          break;
        case "2":
          addResult();
          System.out.println("Результат добавлен");
          break;
        case "3":
          showResults();
          System.out.println("Ввыберите номер результата, который хотите удалить: ");
          /*
           * Проверка на то, чтобы номер результат num был корректный
           */
          int num = sc.nextInt();
          while (num <= 0 || num > results.size()) {
            System.out.println("Правильно введите номер результата: ");
            num = sc.nextInt();
          }
          /*
           * Удаление объекта
           */
          results.remove(num - 1);
          System.out.println("Результат был удален");
          break;
        case "4":
          showResults();
          break;
        case "5":
          if (results.size() < 2) {
            System.out.println("Количество добавленных результатов меньше 2");
            break;
          }
          showResults();
          System.out.println("Введите номер первого результата: ");
          int r1 = sc.nextInt();
          /*
           * Проверка на то, чтобы номер результата r1 был корректный
           */
          while (r1 <= 0 || r1 > results.size()) {
            System.out.println("Правильно введите номер результата: ");
            r1 = sc.nextInt();
          }
          /*
           * Проверка на то, чтобы номер результата r2 был корректный
           */
          System.out.println("Введите номер второго результата: ");
          int r2 = sc.nextInt();
          while (r2 <= 0 || r2 > results.size()) {
            System.out.println("Правильно введите номер результата");
            r2 = sc.nextInt();
          }
          // Получения первого и второго объекта по индексам
          Assay o1 = results.get(r1 - 1);
          Assay o2 = results.get(r2 - 1);
          boolean eq = false;
          // Предварительная проверка объектов на равенство через хеш-код
          if (o1.hashCode() == o2.hashCode()) {
            // Проверка объектов на равенство через метод equals
            if (o1.equals(o2)) {
              System.out.println("Эти резуьтаты равны");
              eq = true;
            }
          }
          if (!eq) {
            System.out.println("Эти результаты не равны");
          }
          sc.nextLine();
          break;
        case "6":
          if (results.isEmpty()) {
            System.out.println("Сначала нужно добавить результаты");
            break;
          }
          showResults();
          System.out.println("Введите номер результата: ");
          // Проверка на то, чтобы номер результата был корректным
          int n = sc.nextInt();
          while (n < 0 || n > results.size()) {
            System.out.println("Правильно введите номер результата");
            n = sc.nextInt();
          }
          sc.nextLine();
          correctResult(results.get(n - 1));
          break;

      }
    }
  }

  /**
   * Метод для отображения всех результатов пользователя
   */
  public static void showResults() {
    System.out.println("Все результаты:");
    for (int i = 1; i <= results.size(); i++) {
      System.out.println(i + ".\n" + results.get(i - 1));
    }
  }

  /**
   * Метод для редактирования значений результата, принимает:
   *
   * @param ob (объект, хранящий результат)
   */
  public static void correctResult(Object ob) {
    String assayName;
    int mark;
    String topic;
    int tasksAmount;
    String subject;
    int topicsAmount;
    String examName;
    int period;
    // Проверка, принадлежит ли объект классу FinalExam и ввод всех данных
    if (ob instanceof FinalExam) {
      System.out.println("Введите название испытания: ");
      assayName = sc.nextLine();
      System.out.println("Введите оценку: ");
      mark = sc.nextInt();
      // Проверка, что оценка была не отрицальной
      while (mark < 0) {
        System.out.println("Оценка должна быть неотрицательной");
        System.out.println("Введите еще раз: ");
        mark = sc.nextInt();
      }
      sc.nextLine();
      System.out.println("Введите название предмета: ");
      subject = sc.nextLine();
      System.out.println("Введите количество тем: ");
      topicsAmount = sc.nextInt();
      // Проверка, чтобы количество тем было положительным
      while (topicsAmount <= 0) {
        System.out.println("Количество тем должно быть положительным");
        System.out.println("Ввыедите еще раз: ");
        topicsAmount = sc.nextInt();
      }
      sc.nextLine();
      System.out.println("Введите название выпускного экзамена");
      examName = sc.nextLine();
      System.out.println("Введите период обучения, за который прошел экзамен (г.)");
      period = sc.nextInt();
      // Проверка, чтобы время обучение было положительным
      while (period <= 0) {
        System.out.println("Период обучения должен быть положительным");
        System.out.println("Ввыедите еще раз: ");
        period = sc.nextInt();
      }
      sc.nextLine();
      // Установка всех значений объекта
      ((FinalExam) ob).setName(assayName);
      ((FinalExam) ob).setMark(mark);
      ((FinalExam) ob).setSubject(subject);
      ((FinalExam) ob).setTopicsAmount(topicsAmount);
      ((FinalExam) ob).setExamName(examName);
      ((FinalExam) ob).setPeriod(period);
      // Проверка, принадлежит ли объект классу Exam и ввод всех параметров
    } else if (ob instanceof Exam) {
      System.out.println("Введите название испытания: ");
      assayName = sc.nextLine();
      System.out.println("Введите оценку: ");
      mark = sc.nextInt();
      // Проверка, чтобы оценка была не отрицательной
      while (mark < 0) {
        System.out.println("Оценка должна быть неотрицательной");
        System.out.println("Введите еще раз: ");
        mark = sc.nextInt();
      }
      sc.nextLine();
      System.out.println("Введите название предмета: ");
      subject = sc.nextLine();
      System.out.println("Введите количество тем: ");
      topicsAmount = sc.nextInt();
      // Проверка, чтобы количество тем было положительным
      while (topicsAmount <= 0) {
        System.out.println("Количество тем должно быть положительным");
        System.out.println("Ввыедите еще раз: ");
        topicsAmount = sc.nextInt();
      }
      sc.nextLine();
      // Установка всех значений объекта
      ((Exam) ob).setName(assayName);
      ((Exam) ob).setMark(mark);
      ((Exam) ob).setSubject(subject);
      ((Exam) ob).setTopicsAmount(topicsAmount);
      // Проверка, принадлежит ли объект классу Test и ввод всех параметров
    } else if (ob instanceof Test) {
      System.out.println("Введите название испытания: ");
      assayName = sc.nextLine();
      System.out.println("Введите оценку: ");
      mark = sc.nextInt();
      // Проверка, чтобы оценка была не отрицательной
      while (mark < 0) {
        System.out.println("Оценка должна быть неотрицательной");
        System.out.println("Введите еще раз: ");
        mark = sc.nextInt();
      }
      sc.nextLine();
      System.out.println("Введите название темы: ");
      topic = sc.nextLine();
      System.out.println("Введите количество заданий: ");
      tasksAmount = sc.nextInt();
      // Проверка, чтобы количество заданий было положительным
      while (tasksAmount <= 0) {
        System.out.println("Количество заданий должно быть положительным");
        System.out.println("Введите еще раз: ");
        tasksAmount = sc.nextInt();
      }
      sc.nextLine();
      // Установка всех значений объекта
      ((Test) ob).setName(assayName);
      ((Test) ob).setMark(mark);
      ((Test) ob).setTopic(topic);
      ((Test) ob).setTasksAmount(tasksAmount);
      // Проверка, принадлежит ли объект классу Assay
    } else if (ob instanceof Assay) {
      System.out.println("Введите название испытания: ");
      assayName = sc.nextLine();
      System.out.println("Введите оценку: ");
      mark = sc.nextInt();
      // Проверка, чтобы оценка была не отрицательной
      while (mark < 0) {
        System.out.println("Оценка должна быть неотрицательной");
        System.out.println("Введите еще раз: ");
        mark = sc.nextInt();
      }
      sc.nextLine();
      // Установка всех значений объекта
      ((Assay) ob).setName(assayName);
      ((Assay) ob).setMark(mark);
    }
  }

  /**
   * Метод для добавления объекта результата в список
   */
  public static void addResult() {
    String assayName;
    int mark;
    String topic;
    int tasksAmount;
    String subject;
    int topicsAmount;
    String examName;
    int period;
    boolean running = true;
    while (running) {
      // Выбор, какой результат пользователь хочет записать
      System.out.println("""
          Варианты пунктов:
          1. Испытание
          2. Тест
          3. Экзамен
          4. Выпускной экзамен
          """);
      // Считывание пункта и выбор действия
      System.out.println("Введите номер пункта, по которому хотите записать результат: ");
      String act = sc.nextLine();
      switch (act) {
        case "1":
          System.out.println("Введите название испытания: ");
          assayName = sc.nextLine();
          System.out.println("Введите полученную оценку: ");
          // Проверка, чтобы оценка была не отрицательной
          mark = sc.nextInt();
          while (mark < 0) {
            System.out.println("Оценка должна быть неотрицательной");
            mark = sc.nextInt();
          }
          sc.nextLine();
          // Добавление нового результата в список
          results.add(new Assay(assayName, mark));
          running = false;
          break;
        case "2":
          System.out.println("Введите название испытания: ");
          assayName = sc.nextLine();
          System.out.println("Введите полученную оценку: ");
          mark = sc.nextInt();
          // Проверка, чтобы оценка была не отрицательной
          while (mark < 0) {
            System.out.println("Оценка должна быть неотрицательной");
            System.out.println("Введите еще раз: ");
            mark = sc.nextInt();
          }
          sc.nextLine();
          System.out.println("Введите название темы: ");
          topic = sc.nextLine();
          System.out.println("Введите количество заданий: ");
          tasksAmount = sc.nextInt();
          // Проверка, чтобы количество заданий было положительным
          while (tasksAmount <= 0) {
            System.out.println("Количество заданий должно быть положительным");
            System.out.println("Введите еще раз: ");
            tasksAmount = sc.nextInt();
          }
          sc.nextLine();
          // Добавление нового результата в список
          results.add(new Test(assayName, mark, topic, tasksAmount));
          running = false;
          break;
        case "3":
          System.out.println("Введите название испытания: ");
          assayName = sc.nextLine();
          System.out.println("Введите полученную оценку: ");
          mark = sc.nextInt();
          // Проверка, чтобы оценка была не отрицательной
          while (mark < 0) {
            System.out.println("Оценка должна быть неотрицательной");
            System.out.println("Введите еще раз: ");
            mark = sc.nextInt();
          }
          sc.nextLine();
          System.out.println("Введите название предмета: ");
          subject = sc.nextLine();
          System.out.println("Введите количество тем: ");
          topicsAmount = sc.nextInt();
          // Проверка, чтобы количество тем было положительным
          while (topicsAmount <= 0) {
            System.out.println("Количество тем должно быть положительным");
            System.out.println("Ввыедите еще раз: ");
            topicsAmount = sc.nextInt();
          }
          sc.nextLine();
          // Добавление нового результата в список
          results.add(new Exam(assayName, mark, subject, topicsAmount));
          running = false;
          break;
        case "4":
          System.out.println("Введите название испытания: ");
          assayName = sc.nextLine();
          System.out.println("Введите полученную оценку: ");
          mark = sc.nextInt();
          // Проверка, чтобы оценка была не отрицательной
          while (mark < 0) {
            System.out.println("Оценка должна быть неотрицательной");
            System.out.println("Введите еще раз: ");
            mark = sc.nextInt();
          }
          sc.nextLine();
          System.out.println("Введите название предмета: ");
          subject = sc.nextLine();
          System.out.println("Введите количество тем: ");
          topicsAmount = sc.nextInt();
          // Проверка, чтобы количество тем было положительным
          while (topicsAmount <= 0) {
            System.out.println("Количество тем должно быть положительным");
            System.out.println("Ввыедите еще раз: ");
            topicsAmount = sc.nextInt();
          }
          sc.nextLine();
          System.out.println("Введите название выпускного экзамена");
          examName = sc.nextLine();
          System.out.println("Введите период обучения, за который прошел экзамен (г.)");
          period = sc.nextInt();
          // Проверка, чтобы время обучения было положительным
          while (period <= 0) {
            System.out.println("Период обучения должен быть положительным");
            System.out.println("Ввыедите еще раз: ");
            period = sc.nextInt();
          }
          sc.nextLine();
          // Добавление нового результата
          results.add(new FinalExam(assayName, mark, subject, topicsAmount, examName, period));
          running = false;
          break;
        default:
          System.out.println("Правильно введите номер пункта");
      }
    }
  }

  /**
   * Метод для добавления пустого поля для результата
   */
  public static void addFieldForResult() {
    boolean running = true;
    while (running) {
      // Список результатов, места под которые пользователь может добавить
      System.out.println("""
          Варианты пунктов:
          1. Испытание
          2. Тест
          3. Экзамен
          4. Выпускной экзамен
          """);
      // Считывание номер пункта и распределение действий
      System.out.println("Введите номер пункта, по которому хотите записать результат:");
      String act = sc.nextLine();
      switch (act) {
        case "1":
          results.add(new Assay());
          running = false;
          break;
        case "2":
          results.add(new Test());
          running = false;
          break;
        case "3":
          results.add(new Exam());
          running = false;
          break;
        case "4":
          results.add(new FinalExam());
          running = false;
          break;
        default:
          System.out.println("Правильно введите номер пункта");
      }
    }
  }
}
