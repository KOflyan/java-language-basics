import { Pokemon } from "../../types/pokemon";
import './PokemonTable.css'

type Props = {
    pokemonData: Pokemon[]
}


export const PokemonTable = ({ pokemonData }: Props) => {
    return <table className="pokemon-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Species</th>
                <th>Type</th>
                <th>Created At</th>
            </tr>
        </thead>
        <tbody>{
            pokemonData.map((p) =>
                <tr>
                    <td>{p.id}</td>
                    <td>{p.species}</td>
                    <td>{p.type}</td>
                    <td>{p.createdAt}</td>
                </tr>
            )
        }</tbody>
    </table>
}

/**
 *   {
 *     "id": 1,
 *     "species": "ditto",
 *     "type": "normal",
 *     "createdAt": "2024-01-29T20:25:58.931869"
 *   },
 */

/**
 * <tr>
 *     <td>1</td>
 *     <td>ditto</td>
 *     <td>normal</td>
 *     <td>2024-01-29T20:25:58.931869</td>
*  </tr
 *
 *
 */