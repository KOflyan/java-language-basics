import { PokemonTable } from "../../components/PokemonTable/PokemonTable";
import './HomePage.css'
import axios from "axios";
import { useEffect, useState } from "react";

export const HomePage = () => {

    const [pokemonData, setPokemonData] = useState([])

    useEffect(() => {
        axios.get('http://localhost:8080/api/pokemon', {
            headers: {
                'Authorization': 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhc2giLCJpYXQiOjE1MTYyMzkwMjJ9.hQ8k-D18Fw4K-jcdxfps0dBfztU9reWyKm0Lc0JGyXI'
            }
        }).then((response) => setPokemonData(response.data))
    }, [setPokemonData])

    return (
        <>
            <div className='header-container'>
                <h1>All Pokemon</h1>
            </div>
            <div className='table-container'>
                <PokemonTable pokemonData={pokemonData}></PokemonTable>
            </div>
        </>
    )
}
