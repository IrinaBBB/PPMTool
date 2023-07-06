import axios from 'axios';
import { GET_ERRORS } from './types';

export const createProject = (project, history) => {
    return async (dispatch) => {
        try {
            const res = await axios.post(
                'http://localhost:8082/api/project',
                project,
            );
        } catch (err) {
            dispatch({
                type: GET_ERRORS,
                payload: err.response.data,
            });
        }
    };
};
