package com.example.spacexapi.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
    data class RocketData(
        val active: Boolean,
        val boosters: Int,
        val company: String,
        val cost_per_launch: Int,
        val country: String,
        val description: String,
        val diameter: Diameter,
        val engines: Engines?,
        val first_flight: String,
        val first_stage: FirstStage,
        val flickr_images: List<String>,
        val height: Height,
        val id: String,
        val landing_legs: LandingLegs,
        val mass: Mass,
        val name: String,
        val payload_weights: List<PayloadWeight>,
        val second_stage: SecondStage,
        val stages: Int,
        val success_rate_pct: Int,
        val type: String,
        val wikipedia: String
    ) : Parcelable {
        @Parcelize
        data class Diameter(
            val feet: Double,
            val meters: Double
        ) : Parcelable
        @Parcelize
        data class Engines(
            // val engine_loss_max: Any,
            val isp: Isp,
            // val layout: Any,
            val number: Int,
            val propellant_1: String,
            val propellant_2: String,
            val thrust_sea_level: ThrustSeaLevel,
            val thrust_to_weight: Double,
            val thrust_vacuum: ThrustVacuum,
            val type: String,
            val version: String
        )  : Parcelable {
            @Parcelize
            data class Isp(
                val sea_level: Int,
                val vacuum: Int
            ) : Parcelable
            @Parcelize
            data class ThrustSeaLevel(
                val kN: Int,
                val lbf: Int
            ) : Parcelable
            @Parcelize
            data class ThrustVacuum(
                val kN: Int,
                val lbf: Int
            ) : Parcelable
        }
        @Parcelize
        data class FirstStage(
            // val burn_time_sec: Any,
            val engines: Int,
            val fuel_amount_tons: Double,
            val reusable: Boolean,
            val thrust_sea_level: ThrustSeaLevel,
            val thrust_vacuum: ThrustVacuum
        )  : Parcelable {
            @Parcelize
            data class ThrustSeaLevel(
                val kN: Int,
                val lbf: Int
            ) : Parcelable
            @Parcelize
            data class ThrustVacuum(
                val kN: Int,
                val lbf: Int
            ) : Parcelable
        }
        @Parcelize
        data class Height(
            val feet: Double,
            val meters: Double
        ) : Parcelable
        @Parcelize
        data class LandingLegs(
            val material: String?,
            val number: Int?
        ) : Parcelable
        @Parcelize
        data class Mass(
            val kg: Int,
            val lb: Int
        ) : Parcelable
        @Parcelize
        data class PayloadWeight(
            val id: String,
            val kg: Int,
            val lb: Int,
            val name: String
        ) : Parcelable
        @Parcelize
        data class SecondStage(
            // val burn_time_sec: Any,
            val engines: Int,
            val fuel_amount_tons: Double,
            val payloads: Payloads,
            val reusable: Boolean,
            val thrust: Thrust
        ) : Parcelable {
            @Parcelize
            data class Payloads(
                val composite_fairing: CompositeFairing,
                val option_1: String
            )  : Parcelable {
                @Parcelize
                data class CompositeFairing(
                    val diameter: Diameter,
                    val height: Height
                ) : Parcelable {
                    @Parcelize
                    data class Diameter(
                        val feet: Double,
                        val meters: Double
                    ) : Parcelable
                    @Parcelize
                    data class Height(
                        val feet: Double,
                        val meters: Double
                    ) : Parcelable
                }
            }
            @Parcelize
            data class Thrust(
                val kN: Int,
                val lbf: Int
            ) : Parcelable
        }
    }