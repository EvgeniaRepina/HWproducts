package ru.netology.manager;

import ru.netology.domain.FilmInformation;

public class FilmManager {
    private FilmInformation[] films = new FilmInformation[0];
    private int filmLimit = 10;

    // ______________ конструкторы_______________________
    public FilmManager(int filmLimit) {
        this.filmLimit = filmLimit;
    }

    public FilmManager() {
    }
//        ________________ геттер________________________

    public FilmInformation[] getFilms() {
        return films;
    }


    //   ___________________________ методы____________________
    public void addFilm(FilmInformation item) {
        // создаём новый массив размером на единицу больше
        int length = films.length + 1;
        FilmInformation[] tmp = new FilmInformation[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < films.length; i++) {
        //   tmp[i] = films[i];
        // }
        System.arraycopy(films, 0, tmp, 0, films.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        films = tmp;
    }

    public FilmInformation[] getAll() {
        FilmInformation[] result = new FilmInformation[films.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public FilmInformation[] getLastLimit() {
        int resultLength;
        if (films.length < filmLimit) {
            resultLength = films.length;
        } else {
            resultLength = filmLimit;
        }

        FilmInformation[] result = new FilmInformation[resultLength];

        if (films.length > filmLimit) {
            for (int i = films.length - 1; i >= films.length - filmLimit; i--) {
                int index = films.length - i - 1;
                result[index] = films[i];
            }

        }
        if (films.length <= filmLimit) {
            for (int i = 0; i < films.length; i++) {
                int index = films.length - i - 1;
                result[i] = films[index];
            }
        }
        return result;
    }


}