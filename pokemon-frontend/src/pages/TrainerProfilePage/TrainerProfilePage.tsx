import './TrainerProfilePage.css'
import { useEffect, useState } from "react";
import axios from "axios";
import { Trainer } from "../../types/trainer";


export const TrainerProfilePage = () => {
    const [trainerData, setTrainerData] = useState<Trainer | null>(null)

    useEffect(() => {
        const token = localStorage.getItem('token')!
        const data = JSON.parse(atob(token.split('.')[1]));

        setTimeout(() => {
            axios.get(`http://localhost:8080/api/trainer/${data.id}`, {
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('token')}`
                }
            }).then((response) => setTrainerData(response.data))
        }, 1_000)
    }, [setTrainerData])


    if (!trainerData) {
        return <div
            style={{
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center'
            }}
        >Loading...</div>
    }


    return (
        <div className='profile-container'>
            <div>
                <h1>Profile</h1>
            </div>
            <div className='profile-section'>
                <span className='label'>ID:</span>
                <span className='value'>{trainerData.id}</span>
            </div>
            <div className='profile-section'>
                <span className='label'>Name:</span>
                <span className='value'>{trainerData.name}</span>
            </div>
            <div className='profile-section'>
                <span className='label'>Role:</span>
                <span className='value'>{trainerData.role}</span>
            </div>
            <div className='profile-section'>
                <span className='label'>Created at:</span>
                <span className='value'>{trainerData.createdAt}</span>
            </div>
        </div>
    )
}