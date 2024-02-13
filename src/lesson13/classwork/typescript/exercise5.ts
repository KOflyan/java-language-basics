type Animal = {
    name: string
    amount: number
    feedingTime: string
}

const animalsAdded: Animal[] = []

function createRow(animal: Animal): HTMLElement {
    const row = document.createElement('tr')

    const nameCol = createColumn(animal.name)
    const amountCol = createColumn(animal.amount)
    const feedingTimeCol = createColumn(animal.feedingTime)

    row.appendChild(nameCol)
    row.appendChild(amountCol)
    row.appendChild(feedingTimeCol)

    return row
}

function createColumn(value: string | number): HTMLElement {
    const element = document.createElement('td')

    element.textContent = value.toString()

    return element
}

function findAnimalByName(name: string): Animal | null {
    for (const animal of animalsAdded) {
        if (animal.name === name) {
            return animal
        }
    }

    return null
}


function addAnimalToTheList(): void {
    const name = (document.getElementById('animal-name') as HTMLInputElement).value
    const feedingTime = (document.getElementById('animal-feeding-time') as HTMLInputElement).value

    const animal: Animal = {
        name,
        amount: 1,
        feedingTime
    }

    const row = createRow(animal)

    animalsAdded.push(animal)
    document.getElementById('animals-list')?.appendChild(row)
}
