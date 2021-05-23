package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Opinion;

public interface OpinionService {

	public void create(Opinion cinemaRoom);

	public Opinion getOpinion(Integer id_opinion);
	public List<Opinion> getAllOpinion();

	public void update(Opinion cinemaRoom);

	public void delete(Opinion cinemaRoom);
}
