Risorse condivise.
Questo progetto sono contenuti tre esercizi:
Simul1 nel quale due thread cercano di accedere alla stessa risorsa condivisa.
Simul2 nel quale due thread cercano di accedere alle stesse due risosrse condivise nello stesso ordine.
Simul3 nel quale due thread cercano di accedere alle stesse due risorse ma in ordine diverso, in questo caso potrebbe verificarsi
un caso di deadlock.
Il file Risorse crea, tramite semaforo, la risorsa da condividere.
Il file Task contiene il runnable del singolo thread.
