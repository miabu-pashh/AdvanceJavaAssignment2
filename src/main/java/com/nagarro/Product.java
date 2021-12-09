package com.nagarro;

import java.util.Comparator;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * The Class Product.
 */
@Entity
@Table(name = "product4")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class Product {

	/** The id. */
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	/** The Id. */
	private String Id;

	/** The name. */
	@Column(name = "name", length = 128, nullable = false, unique = true)
	private String name;

	/** The colour. */
	private String colour;

	/** The gender recomendation. */
	private String gender_recomendation;

	/** The size. */
	private String size;

	/** The price. */
	private String price;

	/** The rating. */
	private String rating;

	/** The availibility. */
	private String availibility;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return Id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.Id = id;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the colour.
	 *
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * Sets the colour.
	 *
	 * @param colour the new colour
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * Gets the gender recomendation.
	 *
	 * @return the gender recomendation
	 */
	public String getGender_recomendation() {
		return gender_recomendation;
	}

	/**
	 * Sets the gender recomendation.
	 *
	 * @param gender_recomendation the new gender recomendation
	 */
	public void setGender_recomendation(String gender_recomendation) {
		this.gender_recomendation = gender_recomendation;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Gets the availibility.
	 *
	 * @return the availibility
	 */
	public String getAvailibility() {
		return availibility;
	}

	/**
	 * Sets the availibility.
	 *
	 * @param availibility the new availibility
	 */
	public void setAvailibility(String availibility) {
		this.availibility = availibility;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", Id=" + Id + ", name=" + name + ", colour=" + colour + ", gender_recomendation="
				+ gender_recomendation + ", size=" + size + ", price=" + price + ", rating=" + rating
				+ ", availibility=" + availibility + "]";
	}

	/**
	 * The Class Comparators.
	 */
	public static final class Comparators {
		
		/** The Constant PRICE. */
		public static final Comparator<Product> PRICE = Comparator.comparing(Product::getPrice,
				Comparator.nullsLast(Comparator.naturalOrder()));

		/** The Constant SIZE. */
		public static final Comparator<Product> SIZE = Comparator.comparing(Product::getPrice,
				Comparator.nullsLast(Comparator.naturalOrder()));

		/** The Constant BOTH. */
		public static final Comparator<Product> BOTH = PRICE.thenComparing(SIZE);

	}
}
