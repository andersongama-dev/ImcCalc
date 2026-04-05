# IMC Calculator (Android • Kotlin)


![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-purple?logo=kotlin)
![Android](https://img.shields.io/badge/Android-SDK-green?logo=android)
![Architecture](https://img.shields.io/badge/Architecture-MVVM-blue)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

Aplicativo Android desenvolvido em **Kotlin** para cálculo do **Índice de Massa Corporal (IMC)**, com análise completa da faixa de peso ideal e recomendações personalizadas para o usuário.

---

## Visão Geral

Este projeto tem como objetivo fornecer uma ferramenta simples, precisa e intuitiva para avaliação do estado corporal com base nos padrões da **Organização Mundial da Saúde (OMS)**.

Além do cálculo tradicional do IMC, o aplicativo:

* Determina a faixa de peso ideal
* Calcula o peso mínimo, médio e máximo saudável
* Informa quantos kg o usuário deve ganhar ou perder

---

## Funcionalidades

* Cálculo automático do IMC
* Classificação segundo padrões da OMS
* Cálculo da faixa de peso ideal
* Feedback personalizado:

  * Peso a ganhar
  * Peso a perder
* Interface simples e responsiva

---

## Fórmulas e Regras de Negócio

### Cálculo do IMC

```
IMC = peso / (altura²)
```

### Faixa de peso saudável

Baseada no intervalo de IMC entre **18.5 e 24.9**:

```
Peso mínimo = 18.5 × (altura²)
Peso máximo = 24.9 × (altura²)
Peso médio  = (mínimo + máximo) / 2
```

### Lógica de recomendação

* Se IMC < 18.5 → Usuário precisa ganhar peso
* Se IMC entre 18.5 e 24.9 → Peso ideal
* Se IMC ≥ 25 → Usuário precisa perder peso

---

## Classificação do IMC

| IMC       | Classificação  |
| --------- | -------------- |
| < 18.5    | Abaixo do peso |
| 18.5–24.9 | Peso normal    |
| 25.0–29.9 | Sobrepeso      |
| 30.0-34.9 | Obesidade I    |
| 35.0-39.9 | Obesidade II   |
| ≥ 40      | Obesidade III  |

---

## Tecnologias

* Kotlin
* Android SDK
* XML (Layouts)
* ViewBinding
* (Opcional) MVVM Architecture
* (Opcional) LiveData / StateFlow

---

## Como executar

```bash
git clone https://github.com/andersongama-dev/ImcCalc.git
```

1. Abra o projeto no **Android Studio**
2. Aguarde o Gradle sincronizar
3. Execute em um emulador ou dispositivo físico

---

## Melhorias futuras

* Validação avançada de inputs
* Internacionalização (i18n)
* Persistência de dados (Room)
* Histórico de medições
* UI com Jetpack Compose
* Testes unitários

---

## Licença

Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

---
