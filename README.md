# Concurrent Orders

Projeto desenvolvido para estudar e comparar **Platform Threads e Virtual Threads em Java**, analisando o desempenho no processamento de múltiplos pedidos simultaneamente.

A aplicação utiliza Spring Boot para executar benchmarks de concorrência, permitindo observar como cada estratégia se comporta em cenários com tarefas que simulam operações bloqueantes.

O objetivo é compreender os benefícios das Virtual Threads, explorar os limites de cada abordagem e avaliar como elas podem contribuir para a escalabilidade de aplicações Java.

## Tecnologias utilizadas

- Java 25
- Spring Boot
- Maven
- MySQL
- Virtual Threads
- Platform Threads

## Objetivo do projeto

Aprender, na prática, como funciona a concorrência em Java e comparar o desempenho das diferentes estratégias de execução por meio de testes com volumes crescentes de pedidos.

## Resultados dos benchmarks

Os testes foram realizados com tarefas que simulam operações bloqueantes utilizando `Thread.sleep(600)`.

### 1.000 pedidos

| Estratégia | Tempo |
|---|---:|
| Platform Threads | 6.019 ms |
| Virtual Threads | 614 ms |

### 10.000 pedidos

| Estratégia | Tempo | Throughput |
|---|---:|---:|
| Platform Threads | 60.054 ms | 166,52 pedidos/s |
| Virtual Threads | 654 ms | 15.290,52 pedidos/s |

## Conclusão

Nos testes realizados, as Virtual Threads apresentaram tempos de execução significativamente menores, demonstrando vantagens na administração de muitas tarefas que passam tempo aguardando.

**Observação:** os resultados correspondem a uma simulação local e não garantem o mesmo desempenho em aplicações reais. Os resultados podem variar conforme o tipo de operação e os recursos disponíveis.