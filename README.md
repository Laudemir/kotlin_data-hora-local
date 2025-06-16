# 📅 Kotlin Data e Hora Local

Projeto Android desenvolvido em **Kotlin** que exibe a **data e hora local em tempo real** em um `TextView` com layout personalizado.

---

## ✨ Funcionalidade

- 🕒 Exibe a **data e hora atual** com atualização automática a cada segundo.
- 🎨 Layout com fundo **azul** e texto **branco**, estilizado com `TextView`.
- ✅ Compatível com versões recentes do Android.

---

## 📷 Captura de Tela

> ![tela](https://github.com/user-attachments/assets/ec1a8dab-3665-4747-bb90-c39e8c872315)


---

## 🚀 Como executar o projeto

1. Clone este repositório:

```bash
git clone https://github.com/Laudemir/kotlin_data-hora-local.git
```

2. Abra no **Android Studio**.
3. Conecte um emulador ou dispositivo físico.
4. Execute o projeto.

---

## 🧱 Estrutura do Projeto

```bash
kotlin_data-hora-local/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/laudemir/datahora/
│   │   │   │   └── MainActivity.kt
│   │   │   ├── res/
│   │   │   │   └── layout/activity_main.xml
│   │   │   └── AndroidManifest.xml
├── build.gradle
└── README.md
```

---

## 🛠️ Tecnologias Utilizadas

- **Kotlin**
- **Android SDK**
- **TextView**
- **Handler + Runnable** para atualização em tempo real
- **ConstraintLayout**

---

## 📄 Código principal

### `MainActivity.kt` – Atualização da hora:

```kotlin
val dateTimeText = findViewById<TextView>(R.id.dateTimeText)

val handler = Handler(Looper.getMainLooper())
val runnable = object : Runnable {
    override fun run() {
        val currentTime = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(Date())
        dateTimeText.text = currentTime
        handler.postDelayed(this, 1000)
    }
}
handler.post(runnable)
```

---

## 🧑‍💻 Autor

**Laudemir Oliveira**  
🔗 [GitHub](https://github.com/Laudemir)
