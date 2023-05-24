package commands;

import mainProgramms.ReplyObj;

public class Help extends Command {
    public static ReplyObj help() {
        ReplyObj replyObj = new ReplyObj();
        replyObj.addString("help : вывести справку по доступным командам");
        replyObj.addString("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.");
        replyObj.addString("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        replyObj.addString("add {element} : добавить новый элемент в коллекцию");
        replyObj.addString("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        replyObj.addString("remove_by_id id : удалить элемент из коллекции по его id");
        replyObj.addString("clear : очистить коллекцию");
        replyObj.addString("save : сохранить коллекцию в файл");
        replyObj.addString("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        replyObj.addString("exit : завершить программу (без сохранения в файл");
        replyObj.addString("remove_first : удалить первый элемент из коллекции");
        replyObj.addString("head : вывести первый элемент коллекции");
        replyObj.addString("remove_greater {element} : удалить из коллекции все элементы, превышающие заданный");
        replyObj.addString("remove_all_by_weapon_type weaponType : удалить из коллекции все элементы, значение поля weaponType которого эквивалентно заданному");
        replyObj.addString("count_by_melee_weapon meleeWeapon : вывести количество элементов, значение поля meleeWeapon которых равно заданному");
        replyObj.addString("print_ascending : вывести элементы коллекции в порядке возрастания");
        return replyObj;
    }
}
