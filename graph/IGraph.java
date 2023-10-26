package graph;

/*
Взвешенный / без весов
Ориентированный / ненаправленный

первая мапа: keyT, weightT, valueT. keyT-Node хранит граф, каждая нода хранит словарь keyT-weightT, где перечислены ее соседи.

 */
public interface IGraph {
    String describe();
}
